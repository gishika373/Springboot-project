// src/services/UserService.jsx

import axios from 'axios';

// const API_URL = 'http://localhost:8090'; // Replace with your backend URL
const API_URL = '/api';

const UserService = {
  getAllUsers: async () => {
    const response = await axios.get(`${API_URL}/user/get-users`);
    return response.data;
  },

  getUserById: async (id) => {
    const response = await axios.get(`${API_URL}/user/get-user/${id}`);
    return response.data;
  },

  createUser: async (userDTO) => {
    const response = await axios.post(`${API_URL}/user/create-user`, userDTO);
    return response.data;
  },

  // Implement other methods as needed
};

export default UserService;
