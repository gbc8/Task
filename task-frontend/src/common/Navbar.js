import React, { useState } from 'react';
import { FormOutlined, HomeOutlined } from '@ant-design/icons';
import { Menu } from 'antd';
const items = [
  {
    label: 'Página Inicial',
    key: 'home',
    icon: <HomeOutlined />,
  },
  {
    label: 'Cadastro',
    key: 'cadastro',
    icon: <FormOutlined />,
  }
];
const Navbar = () => {
  const [current, setCurrent] = useState('tab');
  const onClick = (e) => {
    console.log('click ', e);
    setCurrent(e.key);
  };
  return <Menu onClick={onClick} selectedKeys={[current]} mode="horizontal" items={items} />;
};
export default Navbar;