import React, { useState } from 'react';
import Login from './components/Login';
import Tabs from './components/Tabs';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Função para atualizar o estado de autenticação
  const handleLoginSuccess = () => {
    setIsLoggedIn(true);
  };

  return (
    <div className="mr-2 ml-2 px min-h-screen">
      {!isLoggedIn ? (
        <Login onLoginSuccess={handleLoginSuccess} />
      ) : (
        <Tabs />
      )}
    </div>
  );
}

export default App;
