import api from '../config/api';
import type { ApiResponse } from '../types/api';

export interface LoginRequest {
  email: string;
  password: string;
}

export interface RegisterRequest {
  email: string;
  password: string;
  role: 'TENANT' | 'LANDLORD';
}

export interface AuthResponse {
  accessToken: string;
  refreshToken: string;
}

export async function login(payload: LoginRequest): Promise<ApiResponse<AuthResponse>> {
  const { data } = await api.post<ApiResponse<AuthResponse>>('/api/auth/login', payload);
  return data;
}

export async function register(payload: RegisterRequest): Promise<ApiResponse<AuthResponse>> {
  const { data } = await api.post<ApiResponse<AuthResponse>>('/api/auth/register', payload);
  return data;
}

export async function refreshToken(): Promise<ApiResponse<AuthResponse>> {
  const { data } = await api.post<ApiResponse<AuthResponse>>('/api/auth/refresh');
  return data;
}

export async function logout(): Promise<ApiResponse<void>> {
  const { data } = await api.post<ApiResponse<void>>('/api/auth/logout');
  return data;
}
