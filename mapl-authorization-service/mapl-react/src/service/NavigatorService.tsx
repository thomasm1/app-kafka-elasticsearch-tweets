import axios from 'axios';

const NAVIGATOR_SERVICE_BASE_URL = "http://localhost:9191/api/navigators";

const NAVIGATOR_ID = 2;

class NavigatorService{

    getNavigator(){
        return axios.get(NAVIGATOR_SERVICE_BASE_URL + '/' + NAVIGATOR_ID);
    }

}

export default new NavigatorService