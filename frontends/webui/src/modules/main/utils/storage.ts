export function getStorage(key: string) {
  return sessionStorage.getItem(key);
}

export function setStorage(key: string, value: any) {
  sessionStorage.setItem(key, value);
}

export function deleteStorage(key: string) {
  sessionStorage.removeItem(key);
}

export function clearStorage() {
  sessionStorage.clear();
}
