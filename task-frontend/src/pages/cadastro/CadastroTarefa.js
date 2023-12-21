import React, { useState } from 'react';
import { Button, Form, Input, InputNumber } from 'antd';
import { useNavigate } from "react-router-dom";
import axios from 'axios';

import "../../styles.css";

const CadastroTarefa = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({});

  const handleSubmit = async () => {
    console.log(formData);
    try {
      const response = await axios.post('http://localhost:8082/api/tarefa', formData.tarefa);
      navigate(`/home`);
    } catch (error) {
      console.error('Houve um erro:', error);
    }
  };

  const layout = {
    labelCol: {
      span: 8,
    },
    wrapperCol: {
      span: 16,
    },
  };

  return (
    <>
      <div className="screen">
        <div id="register-form">
          <Form
            {...layout}
            name="nest-messages"
            onFinish={handleSubmit}
            style={{
              maxWidth: 800,
            }}
            onValuesChange={(changedValues, allValues) => {
              // Atualize o estado 'formData' com os novos valores
              setFormData(allValues);
            }}
          >
            <Form.Item
              name={['tarefa', 'titulo']}
              label="Titulo"
              rules={[
                {
                  required: true,
                },
              ]}
            >
              <Input />
            </Form.Item>
            <Form.Item
              name={['tarefa', 'descricao']}
              label="Descrição"
              rules={[
                {
                  required: true,
                },
              ]}
            >
              <Input.TextArea />
            </Form.Item>
            <Form.Item
              name={['tarefa', 'imgPath']}
              label="Endereço da Imagem"
            >
              <Input />
            </Form.Item>
            <Form.Item
              wrapperCol={{
                ...layout.wrapperCol,
                offset: 8,
              }}
            >
              <Button type="primary" htmlType="submit">
                Submit
              </Button>
            </Form.Item>
          </Form>
        </div>
      </div>
    </>
  );

}


export default CadastroTarefa;