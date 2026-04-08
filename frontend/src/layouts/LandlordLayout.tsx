import { Link } from 'react-router-dom';
import type { ReactNode } from 'react';

interface LandlordLayoutProps {
  children: ReactNode;
}

export function LandlordLayout({ children }: LandlordLayoutProps) {
  return (
    <div style={{ display: 'flex', minHeight: '100vh' }}>
      <aside style={{ width: '240px', padding: '1rem', background: '#f3f3f3' }}>
        <h2>Landlord Navigation</h2>
        <nav>
          <div>
            <Link to="/landlord/dashboard">Landlord Dashboard</Link>
          </div>
          <div>
            <Link to="/landlord/listings/new">Listing an apartment</Link>
          </div>
          <div>
            <Link to="/landlord/screening">Screening</Link>
          </div>
          <div>
            <Link to="/landlord/contracts/new">Contract generation</Link>
          </div>
          <div>
            <Link to="/landlord/deposits">Set deposits</Link>
          </div>
          <div>
            <Link to="/landlord/profile">Landlord registration</Link>
          </div>
        </nav>
      </aside>
      <main style={{ flex: 1, padding: '1rem' }}>{children}</main>
    </div>
  );
}

export default LandlordLayout;
