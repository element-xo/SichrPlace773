import api from '../config/api';
import type { ApiResponse } from '../types/api';

export interface ViewingRequestDto {
  listingId: number;
  tenantProfileId: number;
  landlordProfileId: number;
  proposedDatetime: string;
}

export interface ViewingResponse {
  id: number;
  proposedDatetime: string;
}

export async function createViewing(payload: ViewingRequestDto): Promise<ApiResponse<ViewingResponse>> {
  const { data } = await api.post<ApiResponse<ViewingResponse>>('/api/viewings', payload);
  return data;
}

export async function getViewings(): Promise<ApiResponse<ViewingResponse[]>> {
  const { data } = await api.get<ApiResponse<ViewingResponse[]>>('/api/viewings');
  return data;
}

export async function confirmViewing(id: string): Promise<ApiResponse<void>> {
  const { data } = await api.put<ApiResponse<void>>(`/api/viewings/${id}/confirm`);
  return data;
}

export async function rejectViewing(id: string): Promise<ApiResponse<void>> {
  const { data } = await api.put<ApiResponse<void>>(`/api/viewings/${id}/reject`);
  return data;
}
