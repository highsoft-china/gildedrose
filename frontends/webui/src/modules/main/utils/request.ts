import axios from 'axios';
import { getStorage } from './storage';
import { message } from 'antd';

const AUTH_TOKEN = getStorage('token');
const instance = axios.create({
  baseURL: 'https://localhost:3000',
  timeout: 5000,
});

instance.defaults.headers.post['Content-Type'] =
  'application/x-www-form-urlencoded';

// 添加请求拦截器
instance.interceptors.request.use(
  function (config) {
    // 在发送请求之前做些什么
    if (AUTH_TOKEN) {
      config.headers['Authorization'] = `Bearer ${AUTH_TOKEN}`;
    }

    return config;
  },
  function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
  }
);

// 添加响应拦截器
instance.interceptors.response.use(
  function (response) {
    // 对响应数据做点什么
    const res = response.data;

    if (res.code === 200 || res.code === 201) {
      return Promise.resolve(res);
    } else {
      if (res.code === 500 || res.code === 501 || res.code === 502) {
        message.error('您已经登出!');
      }

      return Promise.reject(new Error(res.message || 'Error'));
    }
  },
  function (error) {
    // 对响应错误做点什么
    message.error(error.message);

    return Promise.reject(error);
  }
);

/**
 * get请求
 * @param {*} url 请求地址
 * @param {*} params url参数
 */
export function get(url: string, params: object) {
  return axios.get(url, params);
}

/**
 * post请求
 * @param {*} url 请求地址
 * @param {*} datas url参数
 */
export function post(url: string, datas: object) {
  return axios.post(url, datas);
}

/**
 * put请求
 * @param {*} url 请求地址
 * @param {*} datas url参数
 */
export function put(url: string, datas: object) {
  return axios.put(url, datas);
}

/**
 * delete请求
 * @param {*} url 请求地址
 */
export function del(url: string) {
  return axios.delete(url);
}
