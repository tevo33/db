import React, { useState } from 'react';
import CadastroUsuarios from './CadastroUsuarios';
import CadastroRestaurantes from './CadastroRestaurantes';
import Votacao from './Votacao';

const Tabs = () => {
  const [activeTab, setActiveTab] = useState('usuarios');

  const renderContent = () => {
    switch (activeTab) {
      case 'usuarios':
        return <CadastroUsuarios />;
      case 'restaurantes':
        return <CadastroRestaurantes />;
      case 'votacao':
        return <Votacao />;
      default:
        return null;
    }
  };

  return (
    <div className="w-full">
      <div className="flex border-b">
        <button
          className={`px-4 py-2 focus:outline-none ${
            activeTab === 'usuarios' ? 'border-b-2 border-blue-500 font-semibold' : ''
          }`}
          onClick={() => setActiveTab('usuarios')}
        >
          Cadastro de Usuários
        </button>
        <button
          className={`px-4 py-2 focus:outline-none ${
            activeTab === 'restaurantes' ? 'border-b-2 border-blue-500 font-semibold' : ''
          }`}
          onClick={() => setActiveTab('restaurantes')}
        >
          Cadastro de Restaurantes
        </button>
        <button
          className={`px-4 py-2 focus:outline-none ${
            activeTab === 'votacao' ? 'border-b-2 border-blue-500 font-semibold' : ''
          }`}
          onClick={() => setActiveTab('votacao')}
        >
          Votação
        </button>
      </div>
      <div className="p-4">{renderContent()}</div>
    </div>
  );
};

export default Tabs;
