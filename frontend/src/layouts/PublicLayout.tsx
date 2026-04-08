import { Link } from 'react-router-dom';
import type { ReactNode } from 'react';

interface PublicLayoutProps {
  children: ReactNode;
}

export function PublicLayout({ children }: PublicLayoutProps) {
  return (
    <div>
      <header style={{ padding: '1rem', display: 'flex', justifyContent: 'space-between' }}>
        <div>SichrPlace</div>
        <nav>
          <Link to="/login" style={{ marginRight: '1rem' }}>
            Login
          </Link>
          <Link to="/register">Register</Link>
        </nav>
      </header>
      <main>{children}</main>
    </div>
  );
}

export default PublicLayout;
