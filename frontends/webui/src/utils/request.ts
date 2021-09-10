import axios from 'axios';
import { message } from 'antd';

axios.create({
  baseURL: 'http://localhost:3000',
  timeout: 5000,
});

// 添加请求拦截器
axios.interceptors.request.use(
  function (config) {
    // 在发送请求之前做些什么
    return config;
  },
  function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
  }
);

// 添加响应拦截器
axios.interceptors.response.use(
  function (response: any) {
    // 对响应数据做点什么
    const datas = response.data ? response.data : response.datas;

    return datas;
  },
  function (error) {
    // 对响应错误做点什么
    message.error(error.response.data.message || error.response.data.error);

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
export function post(url: string, datas: object, config={}) {
  return axios.post(url, datas, config);
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
