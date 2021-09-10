import {Suspense} from 'react';
import ReactDOM from 'react-dom';
import reportWebVitals from './reportWebVitals';
import {
    HashRouter as Router,
    Switch,
    Route, Redirect,
} from 'react-router-dom';
import {mainRoutes} from './routes';
import App from './App';
import './styles/index.scss';
import {ConfigProvider, Spin} from 'antd';
import zhCN from 'antd/lib/locale/zh_CN';

ReactDOM.render(
    <Suspense
        fallback={
            <div className="page__loading">
                <Spin size="large"/>
            </div>
        }
    >
        <Router>
            <Switch>
                <Route
                    path="/admin"
                    render={(routeProps) => (
                        <ConfigProvider locale={zhCN}>
                            <App {...routeProps} />
                        </ConfigProvider>
                    )}
                />
                {mainRoutes.map((route: any) => {
                    return <Route key={route.name} {...route} />;
                })}
                <Redirect to="/main" from="/"/>
            </Switch>
        </Router>
    </Suspense>,
    document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
