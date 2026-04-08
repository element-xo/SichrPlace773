import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { setAuth } from '../store/authStore';
import { login as loginRequest } from '../services/authService';

export function LoginPage() {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const response = await loginRequest({ email, password });
    if (response.success) {
      setAuth(response.data.accessToken, { id: 0, email, role: 'TENANT' });
      navigate('/listings');
    }
  };

  return (
    <div>
      <h1>Login</h1>
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
        <button type="submit">Login</button>
      </form>
    </div>
  );
}

export default LoginPage;
