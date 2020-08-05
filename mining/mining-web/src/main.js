import Vue from 'vue'
import Index from './components/Index.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import ECharts from 'vue-echarts'

Vue.component('v-chart', ECharts)
Vue.config.productionTip = false
Vue.use(ElementUI);


new Vue({
  render: h => h(Index),
}).$mount('#app')
