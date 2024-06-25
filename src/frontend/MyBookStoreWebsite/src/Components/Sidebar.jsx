import './Sidebar.css';
import { Link } from 'react-router-dom';


function Sidebar() {

    return (
        <div>
            <aside id="sidebar">
                <div className="d-flex">
                    <button className="toggle-btn" type="button">
                        <i className="lni lni-grid-alt"></i>
                    </button>
                    <div className="sidebar-logo">
                        <Link to="/">Bookish Delights</Link>
                    </div>
                </div>
                <ul className="sidebar-nav">
                    <li className="sidebar-item">
                        <Link to="#" className="sidebar-link">
                            <i className="lni lni-home"></i>
                            <span>Home</span>
                        </Link>
                    </li>
                    <li className="sidebar-item">
                        <Link to="/shoppingCart" className="sidebar-link">
                            <i className="lni lni-cart"></i>
                            <span>Shopping Cart</span>
                        </Link>
                    </li>
                    {/* <li className="sidebar-item">
                        <Link to="#" className="sidebar-link">
                            <i className="lni lni-agenda"></i>
                            <span>My Orders</span>
                        </Link>
                    </li> */}
                </ul>
                <div className="sidebar-footer" style={{ marginTop: '20rem' }}>
                    <Link to="#" className="sidebar-link">
                        <i className="lni lni-exit"></i>
                        <span>Login</span>
                    </Link>
                </div>
            </aside>

        </div>


    );
}

export default Sidebar

