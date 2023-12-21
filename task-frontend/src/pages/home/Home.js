import React, { useEffect, useState } from 'react';
import { Table, Button } from 'antd';
import axios from 'axios';

import "../../styles.css";


const Home = () => {
  const [data, setData] = useState(null);

  const getDataList = () => {
    axios.get('http://localhost:8082/api/tarefa')
      .then(response => {
        setData(response.data)
      })
      .catch(error => {
        console.error('Houve um erro:', error);
      });
  }

  useEffect(() => {
    getDataList()
  }, []);

  const handleButtonClick = async (id) => {
    console.log(`Botão clicado para o ID ${id}`);
    const json = {
      status: 'Concluída'
    }
    try {
      const response = await axios.put(`http://localhost:8082/api/tarefa/${id}`);
    getDataList()
  } catch (error) {
    console.error('Houve um erro:', error);
  }
};

const columns = [
  {
    title: 'No',
    dataIndex: 'id',
    onFilter: (value, record) => record.id.indexOf(value) === 0,
    sorter: (a, b) => a.id - b.id,
    sortDirections: ['descend'],
  },
  {
    title: 'Título',
    dataIndex: 'titulo',
  },
  {
    title: 'Descrição',
    dataIndex: 'descricao',
  },
  {
    title: 'Status',
    dataIndex: 'status',
  },
  {
    title: 'Endereço da Imagem',
    dataIndex: 'imgPath',
  },
  {
    title: 'Ação',
    key: 'action',
    render: (text, record) => (
      record.status !== 'Concluída' ? (
        <Button type="primary" onClick={() => handleButtonClick(record.id)}>
          Concluir
        </Button>
      ) : null
    ),
  },
];

const onChange = (pagination, filters, sorter, extra) => {
  console.log('params', pagination, filters, sorter, extra);
};

return (
  <>
    <Table columns={columns} dataSource={data} onChange={onChange} />
  </>
);
};
export default Home;