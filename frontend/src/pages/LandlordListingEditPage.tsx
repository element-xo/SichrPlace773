import { useParams } from 'react-router-dom';

export function LandlordListingEditPage() {
  const { id } = useParams();

  return (
    <div>
      <h1>Listing an apartment</h1>
      <p>Coming soon</p>
      <p>Listing ID: {id}</p>
    </div>
  );
}

export default LandlordListingEditPage;
