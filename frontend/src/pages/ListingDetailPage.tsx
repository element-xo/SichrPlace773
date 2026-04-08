import { useParams } from 'react-router-dom';

export function ListingDetailPage() {
  const { id } = useParams();

  return (
    <div>
      <h1>Messaging and booking application</h1>
      <p>Coming soon</p>
      <p>Listing ID: {id}</p>
    </div>
  );
}

export default ListingDetailPage;
