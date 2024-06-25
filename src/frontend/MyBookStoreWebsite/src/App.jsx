
import { useEffect } from 'react';
import './App.css';
import Books from './Components/Books';
import Sidebar from './Components/Sidebar';
// import Header from './Components/Header';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ShoppingCart from './Components/ShoppingCart';
import './index.css';

function App() {
  // useEffect(() => {
  //   const hamBurger = document.querySelector(".toggle-btn");

  //   const toggleSidebar = () => {
  //     document.querySelector("#sidebar").classList.toggle("expand");
  //   };

  //   if (hamBurger) {
  //     hamBurger.addEventListener("click", toggleSidebar);
  //   }

  //   // Cleanup event listener on component unmount
  //   return () => {
  //     if (hamBurger) {
  //       hamBurger.removeEventListener("click", toggleSidebar);
  //     }
  //   };
  // }, []);

  return (
    <BrowserRouter>
      <div className="app-container">
        {/* <Header /> */}
        <Sidebar />
        <Routes>
          <Route path='/' element={<Books />} />
          <Route path='shoppingCart' element={<ShoppingCart/>}></Route>
          {/* Add more routes here as needed */}
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;


// import { useEffect } from 'react';
// import './App.css';
// import Books from './Components/Books';
// import Sidebar from './Components/Sidebar';
// import Header from './Components/Header';
// import { BrowserRouter, Route, Routes } from 'react-router-dom';
// import ShoppingCart from './Components/ShoppingCart';
// import './index.css';

// function App() {
//   useEffect(() => {
//     const hamBurger = document.querySelector(".toggle-btn");

//     const toggleSidebar = () => {
//       document.querySelector("#sidebar").classList.toggle("expand");
//     };

//     if (hamBurger) {
//       hamBurger.addEventListener("click", toggleSidebar);
//     }

//     // Cleanup event listener on component unmount
//     return () => {
//       if (hamBurger) {
//         hamBurger.removeEventListener("click", toggleSidebar);
//       }
//     };
//   }, []);

//   return (
//     <BrowserRouter>
//       <div className="flex flex-col h-screen">
//         <Header />
//         <div className="flex flex-1">
//           <Sidebar />
//           <main className="flex-1 p-4 overflow-auto">
//             <Routes>
//               <Route path='/' element={<Books />} />
//               <Route path='shoppingCart' element={<ShoppingCart />} />
//               {/* Add more routes here as needed */}
//             </Routes>
//           </main>
//         </div>
//       </div>
//     </BrowserRouter>
//   );
// }

// export default App;
