import api from '../config/api';
import type { ApiResponse } from '../types/api';

export interface RentScheduleResponse {
  id: number;
  amount: number;
}

export interface DepositResponse {
  id: number;
  depositAmount: number;
}

export async function getRentSchedules(): Promise<ApiResponse<RentScheduleResponse[]>> {
  const { data } = await api.get<ApiResponse<RentScheduleResponse[]>>('/api/payments/rent-schedules');
  return data;
}

export async function getDeposits(): Promise<ApiResponse<DepositResponse[]>> {
  const { data } = await api.get<ApiResponse<DepositResponse[]>>('/api/payments/deposits');
  return data;
}
