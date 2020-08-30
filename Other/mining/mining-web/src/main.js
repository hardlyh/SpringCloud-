import Vue from 'vue'
import Index from './components/Index.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import ECharts from 'vue-echarts'
import apis from '@/utils/api'
import moment from 'moment'; 

Vue.component('v-chart', ECharts)
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.prototype.apis = apis;
moment.locale('zh-cn');
Vue.prototype.moment = moment;



new Vue({
  render: h => h(Index),
}).$mount('#app')
