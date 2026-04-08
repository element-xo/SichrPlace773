import { Link } from 'react-router-dom';
import type { ReactNode } from 'react';

interface AdminLayoutProps {
  children: ReactNode;
}

export function AdminLayout({ children }: AdminLayoutProps) {
  return (
    <div style={{ display: 'flex', minHeight: '100vh' }}>
      <aside style={{ width: '240px', padding: '1rem', background: '#e9e9e9' }}>
        <h2>Admin Navigation</h2>
        <nav>
          <div>
            <Link to="/admin/dashboard">Admin Dashboard</Link>
          </div>
          <div>
            <Link to="/admin/users">User Management</Link>
          </div>
          <div>
            <Link to="/admin/tickets">Support Tickets</Link>
          </div>
        </nav>
      </aside>
      <main style={{ flex: 1, padding: '1rem' }}>{children}</main>
    </div>
  );
}

export default AdminLayout;
