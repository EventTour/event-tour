"use strict";var precacheConfig=[["/index.html","9f84697a284eebacbeddcfe1a9717e56"],["/static/css/main.488cbeed.css","a798d51715627f55c46423c0f0840861"],["/static/js/main.86156984.js","aea4d307a1958da6f92ddd35d37f4662"],["/static/media/roboto-latin-100.987b8457.woff2","987b84570ea69ee660455b8d5e91f5f1"],["/static/media/roboto-latin-100.e9dbbe8a.woff","e9dbbe8a693dd275c16d32feb101f1c1"],["/static/media/roboto-latin-100italic.6232f43d.woff2","6232f43d15b0e7a0bf0fe82e295bdd06"],["/static/media/roboto-latin-100italic.d704bb3d.woff","d704bb3d579b7d5e40880c75705c8a71"],["/static/media/roboto-latin-300.55536c8e.woff2","55536c8e9e9a532651e3cf374f290ea3"],["/static/media/roboto-latin-300.a1471d1d.woff","a1471d1d6431c893582a5f6a250db3f9"],["/static/media/roboto-latin-300italic.210a7c78.woff","210a7c781f5a354a0e4985656ab456d9"],["/static/media/roboto-latin-300italic.d69924b9.woff2","d69924b98acd849cdeba9fbff3f88ea6"],["/static/media/roboto-latin-400.5d4aeb4e.woff2","5d4aeb4e5f5ef754e307d7ffaef688bd"],["/static/media/roboto-latin-400.bafb105b.woff","bafb105baeb22d965c70fe52ba6b49d9"],["/static/media/roboto-latin-400italic.9680d5a0.woff","9680d5a0c32d2fd084e07bbc4c8b2923"],["/static/media/roboto-latin-400italic.d8bcbe72.woff2","d8bcbe724fd6f4ba44d0ee6a2675890f"],["/static/media/roboto-latin-500.28546717.woff2","285467176f7fe6bb6a9c6873b3dad2cc"],["/static/media/roboto-latin-500.de8b7431.woff","de8b7431b74642e830af4d4f4b513ec9"],["/static/media/roboto-latin-500italic.510dec37.woff2","510dec37fa69fba39593e01a469ee018"],["/static/media/roboto-latin-500italic.ffcc050b.woff","ffcc050b2d92d4b14a4fcb527ee0bcc8"],["/static/media/roboto-latin-700.037d8304.woff2","037d830416495def72b7881024c14b7b"],["/static/media/roboto-latin-700.cf6613d1.woff","cf6613d1adf490972c557a8e318e0868"],["/static/media/roboto-latin-700italic.010c1aee.woff2","010c1aeee3c6d1cbb1d5761d80353823"],["/static/media/roboto-latin-700italic.846d1890.woff","846d1890aee87fde5d8ced8eba360c3a"],["/static/media/roboto-latin-900.19b7a0ad.woff2","19b7a0adfdd4f808b53af7e2ce2ad4e5"],["/static/media/roboto-latin-900.8c2ade50.woff","8c2ade503b34e31430d6c98aa29a52a3"],["/static/media/roboto-latin-900italic.7b770d6c.woff2","7b770d6c53423deb1a8e49d3c9175184"],["/static/media/roboto-latin-900italic.bc833e72.woff","bc833e725c137257c2c42a789845d82f"],["/static/media/ubuntu-latin-300.16a73d94.woff2","16a73d944d9825af5a5c1a1f55de8f28"],["/static/media/ubuntu-latin-300.f4731881.woff","f47318810718978402787f6c97d80b3c"],["/static/media/ubuntu-latin-300italic.094f326b.woff2","094f326bbf5d701e828be07645618e13"],["/static/media/ubuntu-latin-300italic.1f11b1e7.woff","1f11b1e747c45516b1a5478480d6cedd"],["/static/media/ubuntu-latin-400.1e926e22.woff","1e926e228a9e2e1e77034f624211e2b4"],["/static/media/ubuntu-latin-400.5b23eeb3.woff2","5b23eeb3a32b30e91682d601535d2a89"],["/static/media/ubuntu-latin-400italic.27149a96.woff","27149a968393dbdc0d872f05f177e843"],["/static/media/ubuntu-latin-400italic.ff2b5b4d.woff2","ff2b5b4da106e880a3f3733fd5d77ceb"],["/static/media/ubuntu-latin-500.b4e565dc.woff2","b4e565dcfc8f6cb332be0fc03302ad99"],["/static/media/ubuntu-latin-500.e5613b0c.woff","e5613b0c875443174f948840c8ce07f6"],["/static/media/ubuntu-latin-500italic.657fed7d.woff2","657fed7d867932571e9fa5fab260ed90"],["/static/media/ubuntu-latin-500italic.f068ac52.woff","f068ac523f3d278ff11cfa4010af4d2a"],["/static/media/ubuntu-latin-700.669545b1.woff","669545b14b8032954bfe46909785c19f"],["/static/media/ubuntu-latin-700.b91fae46.woff2","b91fae466c698c775adb2ae92cecc8b2"],["/static/media/ubuntu-latin-700italic.ad7e4c2f.woff","ad7e4c2f2d357a1eb39a11ecc1ad43aa"],["/static/media/ubuntu-latin-700italic.c02fdf85.woff2","c02fdf8544ee71a10050b800f1c146b1"]],cacheName="sw-precache-v3-sw-precache-webpack-plugin-"+(self.registration?self.registration.scope:""),ignoreUrlParametersMatching=[/^utm_/],addDirectoryIndex=function(e,t){var a=new URL(e);return"/"===a.pathname.slice(-1)&&(a.pathname+=t),a.toString()},cleanResponse=function(t){return t.redirected?("body"in t?Promise.resolve(t.body):t.blob()).then(function(e){return new Response(e,{headers:t.headers,status:t.status,statusText:t.statusText})}):Promise.resolve(t)},createCacheKey=function(e,t,a,i){var c=new URL(e);return i&&c.pathname.match(i)||(c.search+=(c.search?"&":"")+encodeURIComponent(t)+"="+encodeURIComponent(a)),c.toString()},isPathWhitelisted=function(e,t){if(0===e.length)return!0;var a=new URL(t).pathname;return e.some(function(e){return a.match(e)})},stripIgnoredUrlParameters=function(e,a){var t=new URL(e);return t.hash="",t.search=t.search.slice(1).split("&").map(function(e){return e.split("=")}).filter(function(t){return a.every(function(e){return!e.test(t[0])})}).map(function(e){return e.join("=")}).join("&"),t.toString()},hashParamName="_sw-precache",urlsToCacheKeys=new Map(precacheConfig.map(function(e){var t=e[0],a=e[1],i=new URL(t,self.location),c=createCacheKey(i,hashParamName,a,/\.\w{8}\./);return[i.toString(),c]}));function setOfCachedUrls(e){return e.keys().then(function(e){return e.map(function(e){return e.url})}).then(function(e){return new Set(e)})}self.addEventListener("install",function(e){e.waitUntil(caches.open(cacheName).then(function(i){return setOfCachedUrls(i).then(function(a){return Promise.all(Array.from(urlsToCacheKeys.values()).map(function(t){if(!a.has(t)){var e=new Request(t,{credentials:"same-origin"});return fetch(e).then(function(e){if(!e.ok)throw new Error("Request for "+t+" returned a response with status "+e.status);return cleanResponse(e).then(function(e){return i.put(t,e)})})}}))})}).then(function(){return self.skipWaiting()}))}),self.addEventListener("activate",function(e){var a=new Set(urlsToCacheKeys.values());e.waitUntil(caches.open(cacheName).then(function(t){return t.keys().then(function(e){return Promise.all(e.map(function(e){if(!a.has(e.url))return t.delete(e)}))})}).then(function(){return self.clients.claim()}))}),self.addEventListener("fetch",function(t){if("GET"===t.request.method){var e,a=stripIgnoredUrlParameters(t.request.url,ignoreUrlParametersMatching),i="index.html";(e=urlsToCacheKeys.has(a))||(a=addDirectoryIndex(a,i),e=urlsToCacheKeys.has(a));var c="/index.html";!e&&"navigate"===t.request.mode&&isPathWhitelisted(["^(?!\\/__).*"],t.request.url)&&(a=new URL(c,self.location).toString(),e=urlsToCacheKeys.has(a)),e&&t.respondWith(caches.open(cacheName).then(function(e){return e.match(urlsToCacheKeys.get(a)).then(function(e){if(e)return e;throw Error("The cached response that was expected is missing.")})}).catch(function(e){return console.warn('Couldn\'t serve response for "%s" from cache: %O',t.request.url,e),fetch(t.request)}))}});