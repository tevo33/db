import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Votacao = () => {
  const handleIniciarVotacao = () => {
    alert('Votação iniciada!');
  };

  const [restaurants, setRestaurants] = useState([]);

  useEffect(() => 
  {
    axios.get('http://localhost:9033/api/restaurant')
         .then((response) => 
        {
          setRestaurants(response.data);
        } )

        .catch( (error) => 
        {
          console.error('Error fetching data:', error);
        } );
  }, [] );

  return (
    <div>
      <ul>
        {
        restaurants.map((i) => 
        (
          <li key={i.id}>
            <h2>{i.name}</h2>
            <img src={i.imageUrl} width='300px' height='300px'/>
          </li>
        ) )
        }
      </ul>
      <button onClick={handleIniciarVotacao}>Iniciar Votação</button>
    </div>
  );
};

export default Votacao;
