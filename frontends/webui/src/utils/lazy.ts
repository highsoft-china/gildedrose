import React, { ComponentType } from "react";

export function lazy<T extends ComponentType<any>>(factory: () => Promise<{ default: T }>) {
  return React.lazy(factory) as ComponentType<any>;
}
