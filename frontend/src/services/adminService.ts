import api from '../config/api';
import type { ApiResponse } from '../types/api';

export interface UserSummary {
  id: number;
  email: string;
  role: string;
}

export interface TicketSummary {
  id: number;
  subject: string;
  status: string;
}

export interface StatusUpdateRequest {
  status: string;
}

export async function listUsers(): Promise<ApiResponse<UserSummary[]>> {
  const { data } = await api.get<ApiResponse<UserSummary[]>>('/api/admin/users');
  return data;
}

export async function updateUserStatus(id: string, payload: StatusUpdateRequest): Promise<ApiResponse<void>> {
  const { data } = await api.put<ApiResponse<void>>(`/api/admin/users/${id}/status`, payload);
  return data;
}

export async function listTickets(): Promise<ApiResponse<TicketSummary[]>> {
  const { data } = await api.get<ApiResponse<TicketSummary[]>>('/api/admin/tickets');
  return data;
}

export async function updateTicketStatus(id: string, payload: StatusUpdateRequest): Promise<ApiResponse<void>> {
  const { data } = await api.put<ApiResponse<void>>(`/api/admin/tickets/${id}/status`, payload);
  return data;
}
