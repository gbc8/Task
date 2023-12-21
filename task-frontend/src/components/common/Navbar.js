import React, { useState } from 'react';
import { FormOutlined, HomeOutlined } from '@ant-design/icons';
import { useNavigate } from "react-router-dom";
import { Menu } from 'antd';

const Navbar = () => {
  const navigate = useNavigate();
  const [current, setCurrent] = useState('tab');

  const items = [
    {
      label: 'Página Inicial',
      key: 'home',
      icon: <HomeOutlined />,
    }
    ,
    {
      label: 'Cadastro',
      key: 'cadastro',
      icon: <FormOutlined />,
    }
  ]; 

  const handleMenuTabClick = (e) => {
    setCurrent(e.key);
    navigate(`/${e.key}`);
  };

  return <Menu onClick={handleMenuTabClick} selectedKeys={[current]} mode="horizontal" theme="dark" items={items} />;
};
export default Navbar;