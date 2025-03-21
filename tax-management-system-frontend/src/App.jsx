import './App.css';
import { LoginPage } from './pages/LoginPage';
import { HomePage } from './pages/HomePage';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { useNavigate } from "react-router";

function App() {
  const navigate = useNavigate();
  return (
    <div>
        <Routes>
          <Route path="/home" element={<HomePage />} />
          <Route path="/" element={<LoginPage />} />
        </Routes>
    </div>
  );
}

export default App;
