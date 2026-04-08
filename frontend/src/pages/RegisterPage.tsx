import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { register as registerRequest } from '../services/authService';

export function RegisterPage() {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [role, setRole] = useState<'TENANT' | 'LANDLORD'>('TENANT');

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const response = await registerRequest({ email, password, role });
    if (response.success) {
      navigate('/login');
    }
  };

  return (
    <div>
      <h1>Tenant registration</h1>
      <p>Coming soon</p>
      <form onSubmit={handleSubmit}>
        <div>
          <label>
            Email
            <input value={email} onChange={(e) => setEmail(e.target.value)} />
          </label>
        </div>
        <div>
          <label>
            Password
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
          </label>
        </div>
        <div>
          <label>
            Role
            <select value={role} onChange={(e) => setRole(e.target.value as 'TENANT' | 'LANDLORD')}>
              <option value="TENANT">TENANT</option>
              <option value="LANDLORD">LANDLORD</option>
            </select>
          </label>
        </div>
        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default RegisterPage;
