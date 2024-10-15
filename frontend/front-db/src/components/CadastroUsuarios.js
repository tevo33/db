import React, { useState } from 'react';
import axios from 'axios';

const CadastroUsuarios = () => {
  const [nome, setNome] = useState('');
  const [senha, setSenha] = useState('');

  const handleNomeChange = (e) => {
    setNome(e.target.value);
  };

  const handleSenhaChange = (e) => {
    setSenha(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:9033/api/user', {
        name: nome,
        password: senha,
      });
      alert('Usuário cadastrado com sucesso!');
      setNome('');
      setSenha('');
    } catch (error) {
      alert('Erro ao cadastrar usuário:', error);
    }
  };

  return (
    <form className="flex flex-col wid w-1/6 gap-2" onSubmit={handleSubmit}>
      <input
        className="rounded border border-black"
        type="text"
        placeholder="Nome"
        value={nome}
        onChange={handleNomeChange}
      />
      <input
        className="rounded border border-black"
        type="password"
        placeholder="Senha"
        value={senha}
        onChange={handleSenhaChange}
      />
      <button className="rounded border border-white bg-green-400 text-white" type="submit">Cadastrar Usuário</button>
    </form>
  );
};

export default CadastroUsuarios;