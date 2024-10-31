import React from "react";
import "./App.css";
import "./responsive.css";
import "react-toastify/dist/ReactToastify.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import HomeScreen from "./screens/HomeScreen";
import OrderScreen from "./screens/CongesScreen";
import UsersScreen from "./screens/UsersScreen";
import AddEmployee from "./screens/AddEmployee";
import LoginScreen from "./screens/LoginScreen";

function App() {
  return (
    <>
      <Router>
        <Switch>
          <Route path="/" component={HomeScreen} exact />
          <Route path="/conges" component={OrderScreen} />
          <Route path="/addemployee" component={AddEmployee} />
          <Route path="/users" component={UsersScreen} />
          <Route path="/login" component={LoginScreen} />
        </Switch>
      </Router>
    </>
  );
}

export default App;
