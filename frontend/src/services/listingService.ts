import api from '../config/api';
import type { ApiResponse } from '../types/api';

export interface ListingSummary {
  id: number;
  title: string;
  city: string;
  country: string;
}

export interface ListingDetail {
  id: number;
  title: string;
  description?: string;
}

export interface ListingRequest {
  title: string;
  streetAddress: string;
  city: string;
  country: string;
  postalCode: string;
}

export async function getListings(): Promise<ApiResponse<ListingSummary[]>> {
  const { data } = await api.get<ApiResponse<ListingSummary[]>>('/api/listings');
  return data;
}

export async function getListing(id: string): Promise<ApiResponse<ListingDetail>> {
  const { data } = await api.get<ApiResponse<ListingDetail>>(`/api/listings/${id}`);
  return data;
}

export async function createListing(payload: ListingRequest): Promise<ApiResponse<ListingDetail>> {
  const { data } = await api.post<ApiResponse<ListingDetail>>('/api/listings', payload);
  return data;
}

export async function updateListing(id: string, payload: ListingRequest): Promise<ApiResponse<ListingDetail>> {
  const { data } = await api.put<ApiResponse<ListingDetail>>(`/api/listings/${id}`, payload);
  return data;
}

export async function deleteListing(id: string): Promise<ApiResponse<void>> {
  const { data } = await api.delete<ApiResponse<void>>(`/api/listings/${id}`);
  return data;
}
