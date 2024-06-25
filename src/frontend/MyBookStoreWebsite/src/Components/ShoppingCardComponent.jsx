import  { useState, useEffect } from 'react';
import './CardComponent.css';
import ShoppingCartService from './services/ShoppingCartService';

function CardComponent() {

const [cart, setCart] = useState({ books: [] });

  // Fetch the shopping cart on component mount
  useEffect(() => {
    async function fetchShoppingCart() {
      try {
        const cartData = await ShoppingCartService.getShoppingCartById(1);
        console.log(cartData); // Log the fetched cart data
        setCart(cartData);
      } catch (error) {
        console.error('Error fetching cart:', error);
      }
    }
    fetchShoppingCart();
  }, []);

  const removeFromCart = async (shoppingCartId, bookId) => {
    
    try {
      await ShoppingCartService.removeBookFromCart(shoppingCartId, bookId);
      window.location.reload(); // Reload the page to show the updated cart
    } catch (error) {
      console.error('Error removing cart item:', error);
    }
  };

  return (
    <div className="container mx-auto mt-5">
      <div className="text-center mb-5">
        <h2 className="text-2xl font-bold">Total Price: ₹{cart.total_price}</h2>
      </div>

      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
        {cart.books.map((book) => (
          <div className="bg-white rounded-lg shadow-lg overflow-hidden flex flex-col justify-between h-full" key={book.id}>
            <div className="p-5">
              <h5 className="text-xl font-bold mb-2">{book.title}</h5>
              <p className="text-gray-700 mb-2">Author: {book.author}</p>
              <p className="text-gray-700 mb-2">Genre: {book.genre}</p>
              <p className="text-gray-700 mb-2">Rating: {book.rating}</p>
              <a href={book.book_url} className="text-blue-500 hover:underline">Read Book</a>
              <h5 className="text-lg font-bold">Price: ₹{book.price}</h5>
            </div>
            <button onClick={() => removeFromCart(1,book.book_id)} className="m-5 inline-block bg-red-500 text-white py-2 px-4 rounded hover:bg-blue-700 self-start">
              Remove From Cart
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default CardComponent;

