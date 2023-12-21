import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/home/Home';
import CadastroTarefa from './pages/cadastro/CadastroTarefa';
import Navbar from './components/common/Navbar';


const AppRouter = () => {
    return (
        <Router>
            <Navbar />
            <Routes>
                <Route path="/home" element={<Home />} />
                <Route path="/cadastro" element={<CadastroTarefa />} />
            </Routes>
        </Router>
    );
};

export default AppRouter;