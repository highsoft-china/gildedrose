import * as qs from 'qs';

export function stringify(params: any) {
  return { params: params, paramsSerializer: (x: any) => qs.stringify(x, { arrayFormat: 'repeat' }) };
}
