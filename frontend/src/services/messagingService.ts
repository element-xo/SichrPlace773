import api from '../config/api';
import type { ApiResponse } from '../types/api';

export interface MessageThreadSummary {
  id: number;
  subject: string;
}

export interface MessageThreadDetail {
  id: number;
  messages: Array<{ id: number; body: string }>;
}

export interface MessageRequest {
  body: string;
}

export interface MessageThreadRequest {
  listingId: number;
  tenantProfileId: number;
  landlordProfileId: number;
}

export async function getThreads(): Promise<ApiResponse<MessageThreadSummary[]>> {
  const { data } = await api.get<ApiResponse<MessageThreadSummary[]>>('/api/messages/threads');
  return data;
}

export async function getThread(threadId: string): Promise<ApiResponse<MessageThreadDetail>> {
  const { data } = await api.get<ApiResponse<MessageThreadDetail>>(`/api/messages/threads/${threadId}`);
  return data;
}

export async function createThread(payload: MessageThreadRequest): Promise<ApiResponse<MessageThreadDetail>> {
  const { data } = await api.post<ApiResponse<MessageThreadDetail>>('/api/messages/threads', payload);
  return data;
}

export async function postMessage(threadId: string, payload: MessageRequest): Promise<ApiResponse<void>> {
  const { data } = await api.post<ApiResponse<void>>(`/api/messages/threads/${threadId}/messages`, payload);
  return data;
}
