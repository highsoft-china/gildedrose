import { get } from '../../../utils/request';
import {put} from "../utils/request";


export function getProducts(params: object) {
  return get('/api/products', params);
}

export function updateProducts(params: object) {
  return put('/api/products', params);
}
