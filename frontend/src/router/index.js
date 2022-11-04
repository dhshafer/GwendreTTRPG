import Vue from 'vue'
import Router from 'vue-router'
// Home view needs created/imported


Vue.use(Router)

const router = new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home,
            meta: {
            // Will need changed later if authorization implemented
            requiresAuth: false
            }
        }
    ]
})

// *** For future authorization implementation ***
// router.beforeEach((to, from, next) => {
//     // Determine if the route requires Authentication
//     const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
//     // If it does and they are not logged in, send the user to "/login"
//     if (requiresAuth && store.state.token === '') {
//       next("/login");
//     } else {
//       // Else let them go to their next destination
//       next();
//     }
// });
  
export default router;