import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CadastroUsuarios = () => {
  const [nome, setNome] = useState('');
  const [senha, setSenha] = useState('');
  const [users, setUsers] = useState([]);

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
      // Atualizar lista de usuários
      fetchUsers();
    } catch (error) {
      alert('Erro ao cadastrar usuário:', error);
    }
  };

  const fetchUsers = () => {
    axios.get('http://localhost:9033/api/user')
      .then((response) => {
        setUsers(response.data);
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  };

  useEffect(() => {
    fetchUsers();
  }, []);

  const deleteUser = (id) => {
    axios.delete(`http://localhost:9033/api/user/${id}`)
      .then((response) => {
        if (response.status === 200) {
          setUsers(users.filter((user) => user.id !== id)); // Remove o usuário excluído da lista
        }
      })
      .catch((error) => {
        console.error('Error deleting user:', error);
      });
  };

  return (
    <div>
      <form className="flex flex-col w-1/6 gap-2" onSubmit={handleSubmit}>
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
        <button className="rounded border border-white bg-green-400 text-white" type="submit">
          Cadastrar Usuário
        </button>
      </form>
      <div>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody>
            {users.map((i) => (
              <tr key={i.id}>
                <td>{i.id}</td>
                <td>{i.name}</td>
                <td>
                  <button onClick={null} className="text-sky-400">Editar</button>
                </td>
                <td>
                  <button onClick={() => deleteUser(i.id)} className="text-red-400">Excluir</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default CadastroUsuarios;