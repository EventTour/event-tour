const apiSettings = {
  domain: 'http://127.0.0.1',
  port: '9000',
  apiPath: '/api'
};

// const dataPath = apiSettings.domain + ':' + apiSettings.port + apiSettings.apiPath;
const dataPath = apiSettings.apiPath;

export const eventImgPath = 'https://eventtour.s3.amazonaws.com/events/';
export const categoryImgPath = 'https://eventtour.s3.amazonaws.com/public/img/categories/';
export const categoryIconPath = 'https://eventtour.s3.amazonaws.com/public/img/categories/icons/';
export const iconPath = 'https://eventtour.s3.amazonaws.com/public/img/icons/';
export const userPhotoPath = 'https://eventtour.s3.amazonaws.com/public/img/users/';

const dataMap = {
  allEvents: dataPath + '/events/all',
  allCities: dataPath + '/city/all',
  event: dataPath + '/events/info/',
  user: dataPath + '/user',
  userUpdate: dataPath + '/user/update',
  userPhoto: dataPath + '/avatar',
  login: dataPath + '/login',
  register: dataPath + '/register',
  remindPass: dataPath + '/remind',
  registrationConfirm: dataPath + '/register/',
  filterEvents: dataPath + '/events/filter/',
  accommodations: dataPath + '/accommodations/city/',
  transfer: dataPath + '/transfer',
  wishlist: dataPath + '/wishlist/user-events/',
  wishlistAdd: dataPath + '/wishlist/add-event-to-user',
  wishlistRemove: dataPath + '/wishlist/delete-event-from-user',
  purchace: dataPath + '/purchase/all/',
  purchaseAdd: dataPath + '/purchase/add',
  categoryPath: dataPath + "/categories/all",
  languagesPath: dataPath + "/languages/all"
};

export default dataMap;

export const authHeaders = {
  'Authorization': 'Bearer ' + localStorage.getItem('accessToken'),
  'Accept': 'application/json',
  'Content-Type': 'application/json'
};