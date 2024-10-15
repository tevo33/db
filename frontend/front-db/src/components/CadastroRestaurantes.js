import React, { useState } from 'react';
import axios from 'axios';

const CadastroRestaurantes = () => {
  const [nome, setNome] = useState('');
  const [imgUrl, setImgUrl] = useState('');

  const handleNomeChange = (e) => {
    setNome(e.target.value);
  };

  const handleImgUrlChange = (e) => {
    setImgUrl(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:9033/api/restaurant', {
        name: nome,
        imageUrl: imgUrl,
      });
      alert('Restaurante cadastrado com sucesso!');
      setNome('');
      setImgUrl('');
    } catch (error) {
      alert('Erro ao cadastrar restaurante:', error);
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
        type="text"
        placeholder="URL da Imagem"
        value={imgUrl}
        onChange={handleImgUrlChange}
      />
      <button className="rounded border border-white bg-green-400 text-white" type="submit">Cadastrar Restaurante</button>
    </form>
  );
};

export default CadastroRestaurantes;