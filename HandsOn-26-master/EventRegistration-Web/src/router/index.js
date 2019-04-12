import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Eventregistration from '@/components/Eventregistration'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/app',
      name: 'Eventregistration',
      component: Eventregistration
    }
  ]
})
