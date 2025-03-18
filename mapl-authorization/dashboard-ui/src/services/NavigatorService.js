import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/navigators';

export const listNavigators = () => axios.get(REST_API_BASE_URL);

export const createNavigator = (navigator) => axios.post(REST_API_BASE_URL, navigator);

export const getNavigator = (navigatorId) => axios.get(REST_API_BASE_URL + '/' + navigatorId);

export const updateNavigator = (navigatorId, navigator) => axios.put(REST_API_BASE_URL + '/' + navigatorId, navigator);

export const deleteNavigator = (navigatorId) => axios.delete(REST_API_BASE_URL + '/' + navigatorId);