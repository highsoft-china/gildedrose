import { RouteConfig } from 'react-router-config';
import { lazy } from '../utils/lazy';

export const mainRoutes: RouteConfig = [
  {
    name: 'main',
    path: '/main',
    component: lazy(() => import('../modules/main/pages/Main')),
  },
];
