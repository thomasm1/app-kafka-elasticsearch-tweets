import axios from 'axios'

const DEPARTMENT_REST_API_BASE_URL = 'http://localhost:8080/api/dashboards'

export const getAllDashboards = () => axios.get(DEPARTMENT_REST_API_BASE_URL);

export const createDashboard = (dashboard) => axios.post(DEPARTMENT_REST_API_BASE_URL, dashboard);

export const getDashboardById = (dashboardId) => axios.get(DEPARTMENT_REST_API_BASE_URL + '/' + dashboardId);

export const updateDashboard = (dashboardId, dashboard) => axios.put(DEPARTMENT_REST_API_BASE_URL + '/' + dashboardId, dashboard);

export const deleteDashboard = (dashboardId) => axios.delete(DEPARTMENT_REST_API_BASE_URL + '/' + dashboardId);