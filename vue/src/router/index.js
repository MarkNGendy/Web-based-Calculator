import { createRouter, createWebHistory } from "vue-router";
import Calculator from "../components/Calculator.vue";

const routes = [
  {
    path: "/",
    name: "Calculator",
    component: Calculator
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
