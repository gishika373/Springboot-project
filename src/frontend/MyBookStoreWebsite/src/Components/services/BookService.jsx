// src/services/BookService.jsx

import axios from 'axios';

// const API_URL = 'http://localhost:8090'; // Replace with your backend URL
const API_URL = '/api';

const BookService = {
  getAllBooks: async () => {
    const response = await axios.get(`${API_URL}/book/get-books`);
    return response.data;
  },



  // Implement other methods as needed
};

export default BookService;
