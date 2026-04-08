import api from '../config/api';
import type { ApiResponse } from '../types/api';

export interface ContractRequest {
  listingId: number;
  tenantProfileId: number;
  landlordProfileId: number;
  fullNameTenant: string;
  fullNameLandlord: string;
  monthlyRent: number;
  depositAmount: number;
}

export interface ContractResponse {
  id: number;
  fullNameTenant: string;
  fullNameLandlord: string;
  monthlyRent: number;
}

export async function createContract(payload: ContractRequest): Promise<ApiResponse<ContractResponse>> {
  const { data } = await api.post<ApiResponse<ContractResponse>>('/api/contracts', payload);
  return data;
}

export async function getContract(id: string): Promise<ApiResponse<ContractResponse>> {
  const { data } = await api.get<ApiResponse<ContractResponse>>(`/api/contracts/${id}`);
  return data;
}
