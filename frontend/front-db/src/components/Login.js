import React, { useState, useRef } from 'react';
import axios from 'axios';

const Login = ({ onLoginSuccess }) => {
  const [login, setLogin] = useState('');
  const [password, setPassword] = useState('');

  const errorLabel = useRef(null);
  const loginInput = useRef(null);
  const passwordInput = useRef(null);
  
  const handleLoginChange = (e) => {
    setLogin(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = async (e) => 
  {
    e.preventDefault();
    
    try 
    {
      const response = await axios.post('http://localhost:9033/api/user/login', 
      {
        login: login,
        senha: password,
      } );

      if (response.data === true) 
      {
        onLoginSuccess();
      } 
      
      else 
      {
        errorStyle();
      }
    } 

    catch ( error ) 
    {
      errorStyle();
    }
  };

  const errorStyle = () => {
    if (errorLabel.current) {
      errorLabel.current.style.display = "block";
    }
    if (loginInput.current) {
      loginInput.current.style.border = "1px solid red";
    }
    if (passwordInput.current) {
      passwordInput.current.style.border = "1px solid red";
    }
  };

  return (
    <div className="w-full max-w-md mx-auto mt-8">
      <form className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4" onSubmit={handleSubmit}>
        <div className="mb-4">
          <input
            ref={loginInput}
            type="text"
            placeholder="Login"
            value={login}
            onChange={handleLoginChange}
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 
                       leading-tight focus:outline-none focus:shadow-outline"
          />
        </div>
        <div className="mb-6">
          <input
            ref={passwordInput}
            type="password"
            placeholder="Senha"
            value={password}
            onChange={handlePasswordChange}
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 
                       leading-tight focus:outline-none focus:shadow-outline"
          />
        </div>
        <label
          ref={errorLabel}
          className="text-red-500 text-sm mb-4 hidden"
        >
          Erro ao fazer login. Verifique suas credenciais.
        </label>
        <div className="flex items-center justify-between">
          <button type="submit" className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded 
                                           focus:outline-none focus:shadow-outline">
            Login
          </button>
        </div>
      </form>
    </div>
  );
};

export default Login;
