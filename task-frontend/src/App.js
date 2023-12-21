import './App.css';
import Navbar from './components/common/Navbar';
import Home from './pages/home/Home';

import AppRouter from './Router';

function App() {
  return (
    <div className="App">
        <AppRouter />
    </div>
  );
}

export default App;
