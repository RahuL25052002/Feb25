import { BrowserRouter, Route, Routes, useLocation } from "react-router-dom";
import { NavigationBar } from "./components/NavigationBar";
import { Dashboard } from "./components/DashBoard";
import { StudentRegistrationForm } from "./components/StudentRegistrationForm";
import { StudentList } from "./components/StudentList";
import { ToastContainer } from "react-toastify";
import { StudentEditForm } from "./components/StudentEditForm";
import { Login } from "./components/Login";
import { RenderNavigationBar } from "./components/RenderNavigationBar";

function App() {

  
  return (
    <BrowserRouter>
      <RenderNavigationBar/>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/register-student" element={<StudentRegistrationForm />} />
        <Route path="/student-list" element={<StudentList />} />
        <Route path="/edit-student/:id" element={<StudentEditForm />} />
      </Routes>
      <ToastContainer></ToastContainer>
    </BrowserRouter>

  )
}

export default App
