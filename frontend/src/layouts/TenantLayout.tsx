import { Link } from 'react-router-dom';
import type { ReactNode } from 'react';

interface TenantLayoutProps {
  children: ReactNode;
}

export function TenantLayout({ children }: TenantLayoutProps) {
  return (
    <div style={{ display: 'flex', minHeight: '100vh' }}>
      <aside style={{ width: '240px', padding: '1rem', background: '#f7f7f7' }}>
        <h2>Tenant Navigation</h2>
        <nav>
          <div>
            <Link to="/tenant/dashboard">Tenant Dashboard</Link>
          </div>
          <div>
            <Link to="/listings">Listing of apartment listings</Link>
          </div>
          <div>
            <Link to="/messages">Messaging and booking application</Link>
          </div>
          <div>
            <Link to="/viewings">Viewing time discussed with landlord</Link>
          </div>
          <div>
            <Link to="/tenant/profile">Tenant registration</Link>
          </div>
        </nav>
      </aside>
      <main style={{ flex: 1, padding: '1rem' }}>{children}</main>
    </div>
  );
}

export default TenantLayout;
