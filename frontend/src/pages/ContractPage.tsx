import { useParams } from 'react-router-dom';

export function ContractPage() {
  const { id } = useParams();

  return (
    <div>
      <h1>Contract generation</h1>
      <p>Coming soon</p>
      <p>Contract ID: {id}</p>
    </div>
  );
}

export default ContractPage;
